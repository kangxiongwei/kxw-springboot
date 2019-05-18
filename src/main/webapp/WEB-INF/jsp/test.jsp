<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>购买商品测试</title>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <script type="text/javascript">
        for (var i = 0; i < 50000; i++) {
            var params = {
                userId: 1,
                productId: 1,
                quantity: 3
            };
            $.post("./purchase", params, function (result) {
                console.log(JSON.stringify(result))
            });
        }
    </script>
</head>
<body>
   <h1>抢购商品测试</h1>
</body>
</html>