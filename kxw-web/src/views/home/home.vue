<style lang="less">
    @import "./home.less";
    @import "../../styles/common.less";
</style>
<template>
    <div class="home-main">
         <Row :gutter="10" class="margin-top-10">
            <Col :md="24" :lg="8" :style="{marginBottom: '10px'}">
                <Card>
                    <p slot="title" class="card-title">
                        <Icon type="android-map"></Icon>
                        上周每日来访量统计
                    </p>
                    <div class="data-source-row">
                        <visite-volume></visite-volume>
                    </div>
                </Card>
            </Col>
            <Col :md="24" :lg="8" :style="{marginBottom: '10px'}">
                <Card>
                    <p slot="title" class="card-title">
                        <Icon type="ios-pulse-strong"></Icon>
                        数据来源统计
                    </p>
                    <div class="data-source-row">
                        <data-source-pie></data-source-pie>
                    </div>
                </Card>
            </Col>
            <Col :md="24" :lg="8">
                <Card>
                    <p slot="title" class="card-title">
                        <Icon type="android-wifi"></Icon>
                        各类用户服务调用变化统计
                    </p>
                    <div class="data-source-row">
                        <user-flow></user-flow>
                    </div>
                </Card>
            </Col>
        </Row>
        <Row class="margin-top-10">
            <Card>
                <p slot="title" class="card-title">
                    <Icon type="ios-shuffle-strong"></Icon>
                    上周每日服务调用量(万)
                </p>
                <div class="line-chart-cons">
                    <service-requests></service-requests>
                </div>
            </Card>
        </Row>
    </div>
</template>

<script>
import dataSourcePie from './components/dataSourcePie.vue';
import visiteVolume from './components/visiteVolume.vue';
import serviceRequests from './components/serviceRequests.vue';
import userFlow from './components/userFlow.vue';

export default {
    name: 'home',
    components: {
        dataSourcePie,
        visiteVolume,
        serviceRequests,
        userFlow
    },
    // data () {
    //     return {
    //
    //         cityData: cityData,
    //         showAddNewTodo: false,
    //         newToDoItemValue: ''
    //     };
    // },
    computed: {
        avatorPath () {
            return localStorage.avatorImgPath;
        }
    },
    methods: {
        // addNewToDoItem () {
        //     this.showAddNewTodo = true;
        // },
        // addNew () {
        //     if (this.newToDoItemValue.length !== 0) {
        //         this.toDoList.unshift({
        //             title: this.newToDoItemValue
        //         });
        //         setTimeout(() => {
        //             this.newToDoItemValue = '';
        //         }, 200);
        //         this.showAddNewTodo = false;
        //     } else {
        //         this.$Message.error('请输入待办事项内容');
        //     }
        // },
        // cancelAdd () {
        //     this.showAddNewTodo = false;
        //     this.newToDoItemValue = '';
        // }
    }
};
</script>
