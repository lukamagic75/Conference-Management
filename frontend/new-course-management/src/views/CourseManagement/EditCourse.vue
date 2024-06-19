<template>
  <div class="edit-course-dialog">
    <h2>修改课程</h2>
    <form @submit.prevent="updateCourse">
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
import { ref, onMounted } from 'vue'
import axios from 'axios'

const props = defineProps(['courseId'])
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

const fetchCourseDetails = () => {
  axios.get(`/api/courses/${props.courseId}`).then(response => {
    const course = response.data
    name.value = course.name
    description.value = course.description
    order.value = course.order
    author.value = course.author
  }).catch(error => {
    alert('获取课程详情失败: ' + error.response.data.message)
  })
}

const updateCourse = () => {
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

  axios.put(`/api/courses/${props.courseId}`, formData).then(response => {
    // 处理成功的响应
    $emit('close')
    $emit('course-updated')
  }).catch(error => {
    // 处理错误的响应
    alert('修改失败: ' + error.response.data.message)
  })
}

onMounted(() => {
  fetchCourseDetails()
})
</script>

<style scoped>
/* 在这里添加样式 */
</style>
