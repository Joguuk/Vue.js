<template>
    <div class="post-create-page">
        <h1>게시물 작성하기</h1>
        <post-create-form @submit="onSubmit" />
    </div>
</template>

<script>
import PostCreateForm from '@/components/PostCreateForm'
import api from '@/api'

export default {
    name: 'PostCreatePage',
    components: { PostCreateForm },
    middleware: 'isAuthorized',
    methods: {
        onSubmit(payload) {
            const { title, contents } = payload
            api.post('/posts', { title, contents })
                .then(res => {
                    alert('게시물이 성공적으로 작성되었습니다.')
                    this.$router.push({
                        path: '/',
                        params: { postId: res.data.id.toString() }
                    })
                })
                .catch(err => {
                    if (err.response.status === 401) {
                        alert('로그인이 필요합니다.')
                        this.$router.push({ path: '/signin' })
                    } else {
                        alert(err.response.data.msg)
                    }
                })
        },
    }
}
</script>