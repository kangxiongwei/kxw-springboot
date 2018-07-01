<style lang="less">
    @import './login.less';
</style>

<template>
    <div class="login" @keydown.enter="handleSubmit">
        <div class="login-con">
            <Card :bordered="false">
                <p slot="title">
                    <Icon type="log-in"></Icon>
                    欢迎登录
                </p>
                <div class="form-con">
                    <Form ref="loginForm" :model="form" :rules="rules">
                        <FormItem prop="username">
                            <Input v-model="form.username" placeholder="请输入用户名">
                            <span slot="prepend">
                                    <Icon :size="16" type="person"></Icon>
                                </span>
                            </Input>
                        </FormItem>
                        <FormItem prop="password">
                            <Input type="password" v-model="form.password" placeholder="请输入密码">
                            <span slot="prepend">
                                    <Icon :size="14" type="locked"></Icon>
                                </span>
                            </Input>
                        </FormItem>
                        <FormItem>
                            <Button @click="handleSubmit" type="primary" long>登录</Button>
                        </FormItem>
                    </Form>
                    <p class="login-tip">若忘记密码，请联系管理员</p>
                    <p class="login-tip">联系方式：18601102513</p>
                </div>
            </Card>
        </div>
    </div>
</template>

<script>
    import {login} from '../api/http_api.js';
    import Cookies from 'js-cookie';

    export default {
        data () {
            return {
                form: {
                    username: Cookies.get('user'),
                    password: Cookies.get('password')
                },
                rules: {
                    username: [
                        {required: true, message: '账号不能为空', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '密码不能为空', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            async handleSubmit () {
                this.$refs.loginForm.validate(async (valid) => {
                    if (valid) {
                        //cookie中有值，就是用cookie中的值，否则使用表单的值
                        let username = this.form.username;
                        let password = this.form.password;
                        let auth = await login(username, password);
                        if (auth) {
                            Cookies.set('user', username, {expires: 7}); //保留7天
                            Cookies.set('password', password, {expires: 7});
                            this.$store.commit('setAvator', 'http://s6.sinaimg.cn/orignal/45f739a40fea9fe45c9d5');
                            Cookies.set('access', username === 'admin' ? 0 : 1); //设置权限
                            this.$router.push({name: 'home_index'});
                        } else {
                            Cookies.remove('user');
                            Cookies.remove('password');
                            this.$Message.error('您输入的用户名或密码错误，请重新登录');
                        }
                    }
                });
            }
        }
    };
</script>

<style>

</style>
