<template>
  <el-dialog
    :title="!this.saveOrupdate ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="账户" prop="id">
        <el-input v-model="dataForm.id" placeholder="账户"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="密码"></el-input>
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
        saveOrupdate:false,//0表示save，1表示update
        dataForm: {
          id: 0,
          password: ''
        },
        dataRule: {
          id: [
            { required: true, message: '账户不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        console.log(id)
        this.dataForm.id = id || null
        this.visible = true
        this.dataForm.password = null
        console.log(id)
        
        if(id==undefined)
      {
        this.saveOrupdate=false
      }
      else
      {
        this.saveOrupdate=true
      }
      console.log(this.saveOrupdate)
        this.$nextTick(() => {
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/account/account/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.password = data.account.password
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        console.log(this.$http.adornUrl(`/account/account/${!this.saveOrupdate ? 'save' : 'update'}`))
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/account/account/${!this.saveOrupdate ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'password': this.dataForm.password
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
                console.log(data),

                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
