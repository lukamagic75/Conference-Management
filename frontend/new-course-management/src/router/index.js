import { createRouter, createWebHistory } from 'vue-router';
import CourseList from '../views/CourseManagement/CourseList.vue';
import AddCourse from '../views/CourseManagement/AddCourse.vue';
import EditCourse from '../views/CourseManagement/EditCourse.vue';
import Register from '../views/Register.vue';
import Login from '../views/Login.vue';
import UserProfile from '../views/UserProfile.vue';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: CourseList,
        meta: { requiresAuth: true },
    },
    {
        path: '/register',
        name: 'Register',
        component: Register,
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
    },
    {
        path: '/course-list',
        name: 'CourseList',
        component: CourseList,
        meta: { requiresAuth: true },
    },
    {
        path: '/add-course',
        name: 'AddCourse',
        component: AddCourse,
        meta: { requiresAuth: true },
    },
    {
        path: '/edit-course/:id',
        name: 'EditCourse',
        component: EditCourse,
        props: true,
        meta: { requiresAuth: true },
    },
    {
        path: '/user-profile',
        name: 'UserProfile',
        component: UserProfile,
        meta: { requiresAuth: true },
    },
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});

// 路由守卫
router.beforeEach((to, from, next) => {
    const isAuthenticated = !!localStorage.getItem('authToken'); // 使用本地存储来保存用户登录状态
    if (to.matched.some(record => record.meta.requiresAuth) && !isAuthenticated) {
        next({ name: 'Login' });
    } else {
        next();
    }
});

export default router;
