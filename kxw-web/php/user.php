<?php
/**
 * Created by IntelliJ IDEA.
 * User: pan
 * Date: 2018-6-30
 * Time: 14:36
 */
header('Access-Control-Allow-Origin:*');
header('Access-Control-Allow-Methods:*');
header('Content-Type:application/x-www.form-urlencoded');
header('Access-Control-Allow-Credentials:true');
header('Access-Control-Allow-Headers:*');

/*if(strtoupper($_SERVER['REQUEST_METHOD'])== 'OPTIONS'){
    exit;
}*/

include 'response.php';

//返回结果
$response = new response();
$response -> setCode(500);
$response -> setMsg("登录失败");
$response -> setData("error");


//$params = file_get_contents("php://input");
$params = $GLOBALS['HTTP_RAW_POST_DATA'];
echo json_decode($params);
echo "----------------------";


$servername = "localhost";
$username = "root";
$password = "";
$dbname = "panxiang";



$loginUserName = $_POST['username'];
$loginPwd = $_POST['password'];

echo "request params：$loginUserName, $loginPwd";

// 创建连接
$conn = new mysqli($servername, $username, $password, $dbname);

// 检测连接
if ($conn->connect_error) {
    die("connect error: " . $conn->connect_error);
}

$sql = "select * from bd_user where Name = '$loginUserName'";

$result = $conn->query($sql);

if ($result != null && $result->num_rows > 0) {
    // 输出数据
    while ($row = $result->fetch_assoc()) {
        //echo json_encode($row);
        if ($loginPwd == $row['Password']) {
            session_start();
            $_SESSION['loginUser']=$row;
            $response -> setCode(200);
            $response -> setMsg("请求成功");
            $response -> setData("success");
            break;
        }
    }
}

$conn->close();

echo json_encode($response);






