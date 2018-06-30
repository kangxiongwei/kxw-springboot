<template>
    <div>
        <h1>
            <div>{{name}}</div>
        </h1>

    </div>
</template>

<script>
    import axios from 'axios';
    export default {
        name: 'test',
        data () {
            return {
                name: null
            };
        },
        created () {
            this.send();
        },
        methods: {
            send () {
                console.log("调用了send方法")
                axios.get('http://localhost/index.php')
                    .then(res => {
                        console.log(res)
                        this.name = res.data.data
                    });
            }
        }
    };
</script>

<style scoped>

</style>
