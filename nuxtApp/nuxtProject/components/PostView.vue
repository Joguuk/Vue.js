<template>
    <div class="post-view">
        <div>
            <h1>{{ post.bbsTit }}</h1>
            <span>게시물 번호 {{ post.bbsId }}</span>
            <strong>{{ post.regUserId }} . {{ post.regDttm }}</strong>
        </div>
        <p>{{ post.bbsCntn }}</p>
    </div>
</template>

<script>
export default {
    name: 'PostView',
    props: {
        post: {
	        type: Object,
	        required: true,
	        validator (post) {
	            const isValidPostId = typeof post.bbsId === 'number'
	            const isValidTitle = !!post.bbsTit && post.bbsTit.length
	            const isValidContents = post.bbsCntn && post.bbsCntn.length

                console.log(isValidPostId)
                console.log(isValidTitle)
                console.log(isValidContents)

	            return isValidPostId && isValidTitle && isValidContents
	        }
        }
    }
}
</script>