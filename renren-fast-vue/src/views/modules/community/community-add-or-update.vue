<template>
  <el-dialog
    :title="!saveOrupdate ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="组团名" prop="communityName">
      <el-input v-model="dataForm.communityName" placeholder="组团名"></el-input>
    </el-form-item>
    <el-form-item label="校区" prop="campus">
      <el-input v-model="dataForm.campus" placeholder="校区"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        saveOrupdate:false,
        dataForm: {
          communityName: 0,
          campus: ''
        },
        dataRule: {
          communityName: [
            { required: true, message: '组团名不能为空', trigger: 'blur' }
          ],
          campus: [
            { required: true, message: '校区不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.communityName = id || undefined
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.communityName) {
            this.$http({
              url: this.$http.adornUrl(`/community/community/info/${this.dataForm.communityName}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.communityName=data.community.communityName
                this.dataForm.campus = data.community.campus
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/community/community/${!this.dataForm.communityName ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'communityName': this.dataForm.communityName || undefined,
                'campus': this.dataForm.campus
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
