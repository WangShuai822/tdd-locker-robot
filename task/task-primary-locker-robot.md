### 存包
- given 可用箱子为0（已满），when 存包， then 失败
- given 可用箱子大于0（未满），when 存包，then 获取到ticket

### 取包
- given 正常小票，when 取包， then 取包成功
- given 异常小票，when 取包，then 取包失败
- given 已使用的小票， when 取包， then 取包失败

### 多组柜子，按顺序存包
- given 两组柜子，第一组柜子可用箱子大于0（未满），第二组柜子可用箱子大于0（未满）
  when 存包， then 获取到ticket
  
- given 两组柜子，第一组柜子可用箱子为0（已满），第二组柜子可用箱子大于0（未满），
  when 存包， then 获取到ticket
  
- given 两组柜子，第一组柜子可用箱子为0（已满），第二组柜子可用箱子大于0（已满），
  when 存包， then 失败

### 多组柜子，取包 
- given 第一组柜子的正常小票， when 取包，then 取包成功，第一组柜子可用箱子数字+1
- given 第二组柜子的正常小票， when 取包，then 取包成功，第二组柜子可用箱子数字+1

---

### （机器人）存包
- given 一组柜子A，A可用箱子数 > 0，when 存包，then 存包成功，获取到小票，A可用箱子数 - 1
- given 一组柜子A，A可用箱子数 = 0，when 存包，then 存包失败，提示：柜子已满，A可用箱子数 = 0
- given 二组柜子A和B，A可用箱子数 > 0，B可用箱子数 > 0，when 存包，then 存包成功，获取到小票，A可用箱子数 - 1， B可用箱子数不变
- given 二组柜子A和B，A可用箱子数 > 0，B可用箱子数 = 0，when 存包，then 存包成功，获取到小票，A可用箱子数 - 1， B可用箱子数不变
- given 二组柜子A和B，A可用箱子数 = 0，B可用箱子数 > 0，when 存包，then 存包成功，获取到小票，A可用箱子数不变，B可用箱子数 - 1
- given 二组柜子A和B，A可用箱子数 = 0，B可用箱子数 = 0，when 存包，then 存包失败，提示：柜子已满

### （机器人）取包
- given 一组柜子A，小票正常，when 取包，then 取包成功，A可用箱子数 + 1
- given 一组柜子A，小票无效，when 取包，then 取包失败，A可用箱子数不变
- given 两组柜子A和B，小票对应A柜，when 取包，then 取包成功，A可用箱子数 + 1， B可用箱子数不变
- given 两组柜子A和B，小票对应B柜，when 取包，then 取包成功，A可用箱子数不变， B可用箱子数 + 1
- given 两组柜子A和B，小票无效，when 取包，then 取包失败，A可用箱子数不变，B可用箱子数不变
