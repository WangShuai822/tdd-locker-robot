## 存包
- given 机器人管理两个柜子，
第一个柜子可用箱子为2，
第二个柜子可用箱子为1 when 存包， then 获取到ticket，包存入第一个柜子

- given 机器人管理两个柜子，
第一个柜子可用箱子为1，
第二个柜子可用箱子为1 when 存包， then 获取到ticket，包存入第一个柜子

- given 机器人管理两个柜子，
第一个柜子可用箱子为1，
第二个柜子可用箱子为2 when 存包， then 获取到ticket，包存入第二个柜子

- given 机器人管理两个柜子，
第一个柜子可用箱子为0（已满），
第二个柜子可用箱子为0（已满） when 存包， then 失败


## 取包
- given 正常小票，when 取包， then 取包成功
- given 异常小票，when 取包，then 取包失败
- given 已使用的小票，when 取包，then 取包失败