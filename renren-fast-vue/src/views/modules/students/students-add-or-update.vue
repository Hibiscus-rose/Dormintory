<template>
  <el-dialog
    :title="!dataForm.saveOrupdate ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="邮箱"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="dataForm.age" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="房间号" prop="roomId">
      <el-input v-model="dataForm.roomId" placeholder="房间号"></el-input>
    </el-form-item>
    <el-form-item label="楼栋号" prop="buildingId">
      <el-input v-model="dataForm.buildingId" placeholder="楼栋号"></el-input>
    </el-form-item>
    <el-form-item label="电话号码" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="电话号码"></el-input>
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
          studentId: 0,
          name: '',
          sex: '',
          email: '',
          age: '',
          roomId: '',
          buildingId: '',
          phone: ''
        },
        dataRule: {
          studentId:[
            { required: true, message: '学生id不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          roomId: [
            { required: true, message: '房间号不能为空', trigger: 'blur' }
          ],
          buildingId: [
            { required: true, message: '楼栋号不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '电话号码不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.studentId = id || null
        this.visible = true
        if(id==undefined)
      {
        this.saveOrupdate=false
      }
      else
      {
        this.saveOrupdate=true
      }
        this.$nextTick(() => {
          //this.$refs['dataForm'].resetFields()
          if (this.dataForm.studentId) {
            this.$http({
              url: this.$http.adornUrl(`/students/students/info/${this.dataForm.studentId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.students.name
                this.dataForm.sex = data.students.sex
                this.dataForm.email = data.students.email
                this.dataForm.age = data.students.age
                this.dataForm.roomId = data.students.roomId
                this.dataForm.buildingId = data.students.buildingId
                this.dataForm.phone = data.students.phone
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
              url: this.$http.adornUrl(`/students/students/${!this.saveOrupdate ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'studentId': this.dataForm.studentId || undefined,
                'name': this.dataForm.name,
                'sex': this.dataForm.sex,
                'email': this.dataForm.email,
                'age': this.dataForm.age,
                'roomId': this.dataForm.roomId,
                'buildingId': this.dataForm.buildingId,
                'phone': this.dataForm.phone
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
