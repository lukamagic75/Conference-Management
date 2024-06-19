<template>
  <nav class="navbar">
    <div class="container">
      <router-link to="/" class="navbar-brand">课程管理系统</router-link>
      <div class="navbar-menu">
        <router-link to="/course-list" class="navbar-item">课程列表</router-link>
        <router-link to="/add-course" class="navbar-item">新增课程</router-link>
        <router-link to="/user-profile" class="navbar-item">个人信息</router-link>
        <router-link to="/login" class="navbar-item" @click="logout">退出</router-link>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  methods: {
    logout() {
      localStorage.removeItem('authToken');
      this.$router.push('/login');
    },
  },
};
</script>

<style scoped>
.navbar {
  background-color: #333;
  color: white;
  padding: 10px;
}
.navbar-brand, .navbar-item {
  color: white;
  margin-right: 15px;
  text-decoration: none;
}
.navbar-brand:hover, .navbar-item:hover {
  color: #ddd;
}
</style>
