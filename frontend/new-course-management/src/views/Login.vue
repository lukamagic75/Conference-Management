<template>
  <div class="login">
    <h2>登录</h2>
    <el-form :model="loginForm" :rules="rules" ref="loginForm" label-width="100px">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="loginForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="loginForm.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      rules: {
        username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
      }
    };
  },
  methods: {
    onSubmit() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          axios.post('/api/login', this.loginForm)
              .then(response => {
                this.$message.success('登录成功');
                this.$router.push('/');
              })
              .catch(error => {
                this.$message.error('登录失败: ' + error.message);
              });
        }
      });
    }
  }
};
</script>

<style scoped>
.login {
  max-width: 400px;
  margin: 50px auto;
}
</style>
