<template>
  <el-dialog
    :title="!dataForm.roomId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="楼栋号" prop="buildingId">
      <el-input v-model="dataForm.buildingId" placeholder="楼栋号"></el-input>
    </el-form-item>
    <el-form-item label="费用/年" prop="perYearFee">
      <el-input v-model="dataForm.perYearFee" placeholder="费用/年"></el-input>
    </el-form-item>
    <el-form-item label="容量/人" prop="roomCapacity">
      <el-input v-model="dataForm.roomCapacity" placeholder="容量/人"></el-input>
    </el-form-item>
    <el-form-item label="面积/m²" prop="area">
      <el-input v-model="dataForm.area" placeholder="面积/m²"></el-input>
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
        dataForm: {
          roomId: 0,
          buildingId: '',
          perYearFee: '',
          roomCapacity: '',
          area: ''
        },
        dataRule: {
          buildingId: [
            { required: true, message: '楼栋号不能为空', trigger: 'blur' }
          ],
          perYearFee: [
            { required: true, message: '费用/年不能为空', trigger: 'blur' }
          ],
          roomCapacity: [
            { required: true, message: '容量/人不能为空', trigger: 'blur' }
          ],
          area: [
            { required: true, message: '面积/m²不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.roomId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.roomId) {
            this.$http({
              url: this.$http.adornUrl(`/room/room/info/${this.dataForm.roomId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.buildingId = data.room.buildingId
                this.dataForm.perYearFee = data.room.perYearFee
                this.dataForm.roomCapacity = data.room.roomCapacity
                this.dataForm.area = data.room.area
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
              url: this.$http.adornUrl(`/room/room/${!this.dataForm.roomId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'roomId': this.dataForm.roomId || undefined,
                'buildingId': this.dataForm.buildingId,
                'perYearFee': this.dataForm.perYearFee,
                'roomCapacity': this.dataForm.roomCapacity,
                'area': this.dataForm.area
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
