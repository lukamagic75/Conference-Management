<template>
  <div class="course-list">
    <div class="filters">
      <input v-model="searchTerm" placeholder="请输入课程名称" />
      <button @click="search">搜索</button>
    </div>
    <table class="course-table">
      <thead>
      <tr>
        <th>课程名称</th>
        <th>课程描述</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="course in courses" :key="course.id">
        <td>{{ course.name }}</td>
        <td>{{ course.description }}</td>
        <td>
          <button @click="editCourse(course)">修改</button>
          <button @click="deleteCourse(course.id)">删除</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchTerm: '',
      courses: [
        // 你的课程数据
      ],
    };
  },
  methods: {
    search() {
      // 实现搜索功能
    },
    editCourse(course) {
      // 实现编辑功能
    },
    deleteCourse(courseId) {
      // 实现删除功能
    },
  },
};
</script>

<style>
.course-list {
  padding: 20px;
  background-color: #fff; /* 白色背景 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 添加阴影 */
  border-radius: 8px; /* 圆角 */
}

.filters {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.filters input {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 200px;
}

.filters button {
  padding: 10px 20px;
  background-color: #409eff; /* 蓝色按钮 */
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.course-table {
  width: 100%;
  border-collapse: collapse;
}

.course-table th, .course-table td {
  padding: 12px;
  border: 1px solid #eee;
}

.course-table th {
  background-color: #f5f5f5;
}

.course-table tbody tr:nth-child(even) {
  background-color: #fafafa;
}

.course-table button {
  margin: 0 5px;
  padding: 6px 12px;
  background-color: #67c23a; /* 绿色按钮 */
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.course-table button:last-child {
  background-color: #f56c6c; /* 红色按钮 */
}
</style>
