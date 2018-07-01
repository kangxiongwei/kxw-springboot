import axios from 'axios';
import config from '../../script/config';

//区分不同环境下的域名前缀
const ajaxUrl = config.env.indexOf('dev') > -1
    ? 'http://localhost:8080/'
    : '/';

//ajax头部信息
const header = {
    'x-requested-with': 'XMLHttpRequest',
    'Access-Control-Allow-Credentials': 'true'
};

//请求返回code码枚举
const codeEnum = [
    {code: 200, msg: '请求成功'},
    {code: 500, msg: '服务器错误'}
];

//所有api方法
const login = async (username, password) => {
    let res = await axios.post(ajaxUrl + 'login', {}, {
        params: {
            username: username,
            password: password
        },
        headers: header
    });
    return res != null && res.data.code === 200;
};

export {login};



