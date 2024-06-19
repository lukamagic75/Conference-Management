<template>
  <div class="user-profile">
    <h2>个人信息管理</h2>
    <el-form :model="userProfile" ref="userProfile" label-width="100px">
      <el-form-item label="昵称">
        <el-input v-model="userProfile.nickname"></el-input>
      </el-form-item>
      <el-form-item label="手机号码">
        <el-input v-model="userProfile.phone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="userProfile.email"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="userProfile.gender">
          <el-option label="男" value="male"></el-option>
          <el-option label="女" value="female"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>

    <h3>修改密码</h3>
    <el-form :model="passwordForm" ref="passwordForm" label-width="100px">
      <el-form-item label="旧密码" prop="oldPassword">
        <el-input type="password" v-model="passwordForm.oldPassword"></el-input>
      </el-form-item>
      <el-form-item label="新密码" prop="newPassword">
        <el-input type="password" v-model="passwordForm.newPassword"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="confirmPassword">
        <el-input type="password" v-model="passwordForm.confirmPassword"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onChangePassword">修改密码</el-button>
      </el-form-item>
    </el-form>

    <h3>个人信息</h3>
    <ul>
      <li>部门: {{ userProfile.department }}</li>
      <li>角色: {{ userProfile.role }}</li>
      <li>创建日期: {{ userProfile.createdAt }}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'UserProfile',
  data() {
    return {
      userProfile: {
        nickname: '',
        phone: '',
        email: '',
        gender: '',
        department: '',
        role: '',
        createdAt: ''
      },
      passwordForm: {
        oldPassword: '',
        newPassword: '',
        confirmPassword: ''
      }
    };
  },
  created() {
    this.fetchUserProfile();
  },
  methods: {
    fetchUserProfile() {
      axios.get('/api/user/profile')
          .then(response => {
            this.userProfile = response.data;
          })
          .catch(error => {
            this.$message.error('获取个人信息失败: ' + error.message);
          });
    },
    onSubmit() {
      axios.put('/api/user/profile', this.userProfile)
          .then(response => {
            this.$message.success('保存成功');
          })
          .catch(error => {
            this.$message.error('保存失败: ' + error.message);
          });
    },
    onChangePassword() {
      if (this.passwordForm.newPassword !== this.passwordForm.confirmPassword) {
        this.$message.error('新密码和确认密码不一致');
        return;
      }
      axios.put('/api/user/change-password', this.passwordForm)
          .then(response => {
            this.$message.success('密码修改成功');
          })
          .catch(error => {
            this.$message.error('密码修改失败: ' + error.message);
          });
    }
  }
};
</script>

<style scoped>
.user-profile {
  max-width: 600px;
  margin: 50px auto;
}
</style>
