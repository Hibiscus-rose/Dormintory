<template>
  <el-dialog
    :title="!this.saveOrupdate ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="电话号码" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="电话号码"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="dataForm.age" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="负责楼栋号" prop="buildingId">
      <el-input v-model="dataForm.buildingId" placeholder="负责楼栋号"></el-input>
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
          employeeId: 0,
          name: '',
          phone: '',
          sex: '',
          age: '',
          buildingId: ''
        },
        dataRule: {
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '电话号码不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          buildingId: [
            { required: true, message: '负责楼栋号不能为空', trigger: 'blur' }
          ],
          employeeId: [
            { required: true, message: '职工号不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.employeeId = id || null
        this.visible = true
        if(id==null)
          {
            this.saveOrupdate=false
          }
        else
          {
             this.saveOrupdate=true
          }
        this.$nextTick(() => {
         // this.$refs['dataForm'].resetFields()
          if (this.dataForm.employeeId) {
            this.$http({
              url: this.$http.adornUrl(`/DormSupervisor/dormsupervisor/info/${this.dataForm.employeeId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.dormsupervisor.name
                this.dataForm.phone = data.dormsupervisor.phone
                this.dataForm.sex = data.dormsupervisor.sex
                this.dataForm.age = data.dormsupervisor.age
                this.dataForm.buildingId = data.dormsupervisor.buildingId
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
              url: this.$http.adornUrl(`/DormSupervisor/dormsupervisor/${!this.saveOrupdate ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'employeeId': this.dataForm.employeeId || undefined,
                'name': this.dataForm.name,
                'phone': this.dataForm.phone,
                'sex': this.dataForm.sex,
                'age': this.dataForm.age,
                'buildingId': this.dataForm.buildingId
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
