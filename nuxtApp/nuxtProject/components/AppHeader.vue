<template>
    <div class="app-header">
        <nuxt-link :to="{ path: '/' }">
            <h1>Nuxt Board</h1>
        </nuxt-link>
        <div v-if="isAuthorized">
            <strong>
                <button @click="toggle" :class="[ isActive ? 'fas fa-sort-up' : 'fas fa-sort-down' ]">{{ me.name }}님 환영합니다.
                <!-- <button @click="toggle">{{ me.name }}님 환영합니다. -->
                    <!-- <i v-if="!isActive" class="fas fa-sort-down"></i>
                    <i v-else class="fas fa-sort-up"></i> -->
                </button>
            </strong>
            <!-- v-if를 통해 엘리먼트를 DOM에 표현할지 제어할 수 있습니다. 
                 * v-show는 css display 속성을 통해 제어합니다. -->
            <ul v-if="isActive">
                <li><button @click="onClickSignout">로그아웃</button></li>
            </ul>
        </div>
        <div v-else>
            <nuxt-link :to="{ path: '/signin' }">로그인</nuxt-link>
        </div>
    </div>
</template>

<script>
import { mapGetters, mapState, mapActions } from 'vuex'

export default {
    name: 'AppHeader',
    data() {
        return {
            isActive: false
        }
    },
    methods: {
        toggle() {
            this.isActive = !this.isActive
        },
        onClickSignout() {
            this.signout()
            // this.$router.push({ name: 'PostListPage' })
        },
        ...mapActions([ 'signout' ])
    },
    computed: {
        ...mapGetters([ 'isAuthorized' ]),
        ...mapState([ 'me' ]),
    }
}
</script>