
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"></meta>
    <title>PDF</title>
    <style>
        html,body,page {
            width:100%;
            height:100%;
        }
        * {
            margin: 0;
            padding: 0;
        }
        page[size="A4"] {
            display: block;
            margin: 0 auto;
        }
        page{
            display: block;
            margin: 0;
        }
        page .home{
            width: 100%;
            height: 100%;
            background: url("${basePath}/img/cover.jpg") no-repeat;
            background-size: 100% 100%;
        }
        @page{
            margin: 0;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<page class="home" size="A4"></page>
</body>
</html>