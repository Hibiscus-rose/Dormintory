<template>
  <el-dialog
    :title="!this.saveOrupdate ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="楼栋号" prop="buildingId">
      <el-input v-model="dataForm.buildingId" placeholder="楼栋号"></el-input>
    </el-form-item>
    <el-form-item label="楼栋名" prop="buildingName">
      <el-input v-model="dataForm.buildingName" placeholder="楼栋名"></el-input>
    </el-form-item>
    <el-form-item label="组团名" prop="communityName">
      <el-select v-model="dataForm.communityName" placeholder="请选择组团">
        <el-option
        v-for="qCommunity in QueryCommunity"
          :value="qCommunity.communityName"
          :label="qCommunity.communityName"
          :key="qCommunity.communityName"
      />
      </el-select>
    </el-form-item>
    <el-form-item label="房间数量" prop="roomNumber">
      <el-input v-model="dataForm.roomNumber" placeholder="房间数量"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
import { create } from 'lodash';
import { method } from 'lodash';

  export default {
    data () {
      return {
        visible: false,
        saveOrupdate:false,//0为新增，1为修改
        dataForm: {
          buildingId: '',
          buildingName: '',
          communityName: '',
          roomNumber: ''
        },
        QueryCommunity:
        [

        ],
        dataRule: {
          buildingId: [
            { required: true, message: '楼栋号不能为空', trigger: 'blur' }
          ],
          buildingName: [
            { required: true, message: '楼栋名不能为空', trigger: 'blur' }
          ],
          communityName: [
            { required: true, message: '组团名不能为空', trigger: 'blur' }
          ],
          roomNumber: [
            { required: true, message: '房间数量不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {

      init (id) {
        this.dataForm.buildingId = id || undefined
        this.visible = true
        if (this.addOrUpdateVisible) {
         this.addOrUpdateVisible = false;
       }
       this.addOrUpdateVisible = true;
       this.fetchCommunity();
       // 清空之前可能残留的数据
       if(id==undefined)
       {
        this.saveOrupdate=false
       }
       else
       {
        this.saveOrupdate=true
       }
       this.dataForm = {
        buildingId: id || undefined,
        buildingName: '',
        communityName: '',
        roomNumber: ''
      };
        this.$nextTick(() => {
          if (this.saveOrupdate) {
            this.$http({
              url: this.$http.adornUrl(`/buildings/buildings/info/${this.dataForm.buildingId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.buildingName = data.buildings.buildingName
                this.dataForm.communityName = data.buildings.communityName
                this.dataForm.roomNumber = data.buildings.roomNumber
              }
            })
          }
        })
      },
      //获取已有组团名
      fetchCommunity()
      {
        console.log("executing fetch");
        this.$http({
          url: this.$http.adornUrl(`/community/community/findAll`),
          method: 'get',
          params: this.$http.adornParams()
        })
      .then(({ data }) => {
        console.log(data);
        console.log(data.list);
        console.log(data.list.communityName);
          if (data && data.code === 0&& Array.isArray(data.list)) {
            // 遍历数组获取 communityName 属性并存储在新数组中
            this.QueryCommunity=data.list;
          }
        })
      .catch((error) => {
          console.error('Error fetching data:', error);
          if (error.response && error.response.data && error.response.data.message) {
            console.error('Error message:', error.response.data.message);
          }
        });
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/buildings/buildings/${!this.saveOrupdate ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'buildingId': this.dataForm.buildingId || undefined,
                'buildingName': this.dataForm.buildingName,
                'communityName': this.dataForm.communityName,
                'roomNumber': this.dataForm.roomNumber
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
