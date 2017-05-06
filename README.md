# 概述

用于cropit后台接收图片，与本工具配合的jquery.cropit.package源码见：[jquery.cropit.package](https://github.com/Strangeen/jquery.cropit.package)

# 文档

## 类
CropitUtil

### 方法

### 1. public static String recieveImg(req, parentPath, fileName, rootPath)

- ### 参数
    req - HttpServletRequest

    parentPath - 图片存放父路径
    
    fileName - 图片存放文件名（不包含后缀）
    
    rootPath - 网站根路径，用于截取图片绝对路径，可为null

- ### 返回
    String - 图片存放相对路径（相对网站根目录的绝对路径），如果rootPath为null则返回绝对路径

### 2. public static String recieveImg(HttpServletRequest req, String paraName, String parentPath, String fileName, String rootPath)

- ### 参数
    req - HttpServletRequest

    paraName - 接收图片数据的参数名
    
    parentPath - 图片存放父路径
    
    fileName - 图片存放文件名（不包含后缀）
    
    rootPath - 网站根路径，用于截取图片绝对路径，可为null

- ### 返回
    String - 图片存放相对路径（相对网站根目录的绝对路径），如果rootPath为null则返回绝对路径