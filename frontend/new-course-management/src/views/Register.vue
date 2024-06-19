<template>
  <div class="register">
    <h2>企业租户注册</h2>
    <el-form :model="registerForm" :rules="rules" ref="registerForm" label-width="100px">
      <el-form-item label="企业名称" prop="companyName">
        <el-input v-model="registerForm.companyName"></el-input>
      </el-form-item>
      <el-form-item label="联系方式" prop="contactInfo">
        <el-input v-model="registerForm.contactInfo"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="registerForm.password"></el-input>
      </el-form-item>
      <el-form-item label="验证码" prop="verificationCode">
        <el-input v-model="registerForm.verificationCode"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Register',
  data() {
    return {
      registerForm: {
        companyName: '',
        contactInfo: '',
        password: '',
        verificationCode: ''
      },
      rules: {
        companyName: [{ required: true, message: '请输入企业名称', trigger: 'blur' }],
        contactInfo: [{ required: true, message: '请输入联系方式', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        verificationCode: [{ required: true, message: '请输入验证码', trigger: 'blur' }]
      }
    };
  },
  methods: {
    onSubmit() {
      this.$refs.registerForm.validate(valid => {
        if (valid) {
          axios.post('/api/register', this.registerForm)
              .then(response => {
                this.$message.success('注册成功');
                this.$router.push('/login');
              })
              .catch(error => {
                this.$message.error('注册失败: ' + error.message);
              });
        }
      });
    }
  }
};
</script>

<style scoped>
.register {
  max-width: 400px;
  margin: 50px auto;
}
</style>
