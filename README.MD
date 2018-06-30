#项目结构
```markdown
├── src                   Java根目录
│   ├── main              
│   │   ├──java           
│   │   └──resources      Java配置文件，包括spring、mybatis等 
│   └── test              Java测试目录
│
├── kxw-web               前端代码根目录
```

#使用方法

+ 测试环境开发启动
  - 右键点击运行org.kxw.springboot.Application类的main方法
  - 进入kxw-web目录，运行npm run dev启动前端代码
  - 查看打开的浏览器页面
  
+ 正式环境发布
  - 首先进入kxw-springboot更目录，运行gradle clean assemble -Pprofile=prod -x test --stacktrace打包
  - 拷贝kxw-springboot/build/libs/kxw-springboot-xxx.jar到需要发布的目录
  - 运行命令java -jar kxw-springboot-xxx.jar启动项目
  - 打开浏览器，输入http://{ip}:8080/访问，如果有域名，请将ip+port替换为域名
  

