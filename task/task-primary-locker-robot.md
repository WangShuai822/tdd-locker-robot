### 存包
- given 可用箱子为0（已满） ，when 存包， then 失败
- given 可用箱子大于0（未满），when 存包，then 获取到ticket

### 取包
- given 正常小票，when 取包， then 取包成功
- given 异常小票，when 取包，then 取包失败
- given 已使用的小票， when 取包， then 取包失败

### 多个柜子，按顺序存包
- given 两组柜子，第一组柜子可用箱子大于0（未满），第二组柜子可用箱子大于0（未满）
  when 存包， then 获取到1号柜子的ticket
  
- given 两组柜子，第一组柜子可用箱子为0（已满），第二组柜子可用箱子大于0（未满），
  when 存包， then 获取到2号柜子ticket
  
- given 两组柜子，第一组柜子可用箱子为0（已满），第二组柜子可用箱子大于0（已满），
  when 存包， then 失败

### 多个柜子，取包 


