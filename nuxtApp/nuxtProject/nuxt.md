# nuxtjs 특징

## 1. layout

- 페이지 컴포넌트를 레이아웃에 렌더링하기 위해서 꼭 <nuxt/> 태그를 작성하세요

## 2. router
### - pages 디렉토리 내의 Vue 파일 구조를 기반으로 vue-router 설정을 자동으로 생성합니다

```
 /
--| user/
-----| index.vue
-----| one.vue
--| index.vue
```

```javascript
router: {
  routes: [
    {
      name: 'index',
      path: '/',
      component: 'pages/index.vue'
    },
    {
      name: 'user',
      path: '/user',
      component: 'pages/user/index.vue'
    },
    {
      name: 'user-one',
      path: '/user/one',
      component: 'pages/user/one.vue'
    }
  ]
}
```

### - 동적 라우트
- 파라메터가 있는 동적 라우트를 정의하기 위해서는 앞에 밑줄이 붙은 .vue 파일이나 폴더를 정의해야합니다.

``````javascript
pages/
--| _slug/
-----| comments.vue
-----| index.vue
--| users/
-----| _id.vue
--| index.vue
```

``````javascript
router: {
  routes: [
    {
      name: 'index',
      path: '/',
      component: 'pages/index.vue'
    },
    {
      name: 'users-id',
      path: '/users/:id?',
      component: 'pages/users/_id.vue'
    },
    {
      name: 'slug',
      path: '/:slug',
      component: 'pages/_slug/index.vue'
    },
    {
      name: 'slug-comments',
      path: '/:slug/comments',
      component: 'pages/_slug/comments.vue'
    }
  ]
}
```

- 위에서 볼 수 있듯이, users-id 라우트는 :id?라는 선택적 경로를 가집니다. 만약 이를 필수 경로로 만드려면 users/_id 폴더 안에 index.vue 파일을 만듭니다.

```javascript
export default {
  validate ({ params }) {
    // Must be a number
    return /^\d+$/.test(params.id)
  }
}
```

- 만약 validate 메소드가 true를 반환하지 않는다면 Nuxt.js는 자동으로 404 error 페이지를 로딩할 것

## 3. 인스턴스 속성

- asyncData
    - store를 사용하지 않고 서버사이드에서 데이터를 가져오고 렌더링하고 싶을 때 사용. 
    - pages 에서만 사용 가능.
    - asyncData의 반환 값은 data와 합쳐집니다. 따라서 위의 예처럼 사용할 경우 템플릿에서 아래와 같이 사용할 수 있게됩니다
```javascript
<template>
  <h1>{{ title }}</h1>
</template>
...
export default {
  asyncData ({ params }) {
    return axios.get(`https://..../${params.id}`)
    .then((res) => {
      return { title: res.data.title }
    })
  }
}
```

- fetch
    - 페이지가 렌더링되기 전에 스토어를 채우기위해 사용.
    - 컴포넌트가 로딩되기 전에 매번 호출
    - 컴포넌트가 화면에 부착되고 나서(mounted) fetch 안의 데이터 호출 로직이 실행

- validate


## 4. 서버 사이드 렌더링의 단점

- 뷰 싱글 페이지 애플리케이션의 라이프 사이클 훅과는 다른 환경(브라우저가 아닌 Node.js)에서 동작하기 때문에 beforeCreate와 created에서 window나 document와 같은 브라우저 객체에 접근할 수 없습니다.

- 서버 사이드 렌더링의 경우 컴포넌트가 최초로 생성되는 시점이 브라우저 위가 아니라 Node.js 환경이기 때문에 beforeCreate나 created에서 브라우저 객체를 접근할 수 없습니다. 대신 beforeMount나 mounted에서 window와 document를 접근할 수 있습니다.


---
# ref
- https://develop365.gitlab.io/nuxtjs-0.10.7-doc/ko/api/components-nuxt-link/
- https://develop365.gitlab.io/nuxtjs-0.10.7-doc/ko/guide/views/
- https://joshua1988.github.io/vue-camp/nuxt/data-fetching.html#싱글-페이지-애플리케이션과-다른-점