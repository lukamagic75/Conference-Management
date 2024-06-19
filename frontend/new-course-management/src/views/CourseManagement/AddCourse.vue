<template>
  <div class="add-course-dialog">
    <h2>新增课程</h2>
    <form @submit.prevent="addCourse">
      <div>
        <label>课程名称:</label>
        <input v-model="name" required />
      </div>
      <div>
        <label>课程简介:</label>
        <textarea v-model="description" required></textarea>
      </div>
      <div>
        <label>课程排序:</label>
        <input v-model="order" required />
      </div>
      <div>
        <label>课程作者:</label>
        <input v-model="author" required />
      </div>
      <div>
        <label>课程封面:</label>
        <input type="file" @change="handleCoverUpload" />
      </div>
      <div>
        <label>课程视频:</label>
        <input type="file" accept="video/mp4" @change="handleVideoUpload" />
      </div>
      <div>
        <button type="submit">确定</button>
        <button type="button" @click="$emit('close')">取消</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const name = ref('')
const description = ref('')
const order = ref('')
const author = ref('')
const cover = ref(null)
const video = ref(null)

const handleCoverUpload = (event) => {
  cover.value = event.target.files[0]
}

const handleVideoUpload = (event) => {
  video.value = event.target.files[0]
}

const addCourse = () => {
  const formData = new FormData()
  formData.append('name', name.value)
  formData.append('description', description.value)
  formData.append('order', order.value)
  formData.append('author', author.value)
  if (cover.value) {
    formData.append('cover', cover.value)
  }
  if (video.value) {
    formData.append('video', video.value)
  }

  axios.post('/api/courses', formData).then(response => {
    // 处理成功的响应
    $emit('close')
    $emit('course-added')
  }).catch(error => {
    // 处理错误的响应
    alert('创建失败: ' + error.response.data.message)
  })
}
</script>

<style scoped>
/* 在这里添加样式 */
</style>
