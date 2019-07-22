
- 注意test里面更改后需要重新的mvn install 一下
## 数据结构

- 稀疏数组（Sparsearray）
  （行不固定，列固定3列。第一行是行数、列数、有效数据个数。真正的数据记录是从第二行开始）
- 二维数组转稀疏数组的思路 
1.遍历 原始的二维数组，得到有效的数据的个数
2. 根据sum就可以创建稀疏数组 int[sum+1][3]。（稀疏数组的列固定为3列） 
3. 将二维数组中有效数据存放进稀疏数组里面。（对应的行号、列号、值）

如
原始的二维数组~~
0	0	0	0	0	0	0	0	0	0	0	
0	0	1	0	0	0	0	0	0	0	0	
0	0	0	2	0	0	0	0	0	0	0	
0	0	0	0	0	0	0	0	0	0	0	
0	0	0	0	0	2	0	0	0	0	0	
0	0	0	0	0	0	0	0	0	0	0	
0	0	0	0	0	0	0	0	0	0	0	
0	0	0	0	0	0	0	0	0	0	0	
0	0	0	0	0	0	0	0	0	0	0	
0	0	0	0	0	0	0	0	0	0	0	
0	0	0	0	0	0	0	0	0	0	0	

稀疏数组
得到稀疏数组为~~~~
11	11	3	
1	2	1	
2	3	2	
4	5	2	


- 数组模拟队列（ArrayQueue）
  - 注意标注队首、队尾、最大的容量

- 用数组模拟环形队列（CircleArrayQueue）
  - 注意其中的几个精妙的算法，如何知道队列满和空，怎么取值，怎么进行下标的移动
  
  
- 链表
  - 单链表(只能一个方向一个一个遍历，不能实现自我删除，只能找到后面节点然后指向这个节点)：
  - 注意2种类型：1、无序添加 2、按照序号进行添加SingleLinkedList
  - 单链表（BAT的面试题，有难度）：1、获取列表的节点个数。2、查找单链表中的倒数第k个结点
    【新浪面试题】 3、将单链表反转 4、逆序打印
  - 双向链表：doublelinklist
    - 烧脑：如何在一个双向链表的指定位置增加一个节点。插入头、尾、中间addBySite方法
        双向链表的测试
        HeroNode [no=1, name=宋江, nickname=及时雨]
        HeroNode [no=2, name=卢俊义, nickname=玉麒麟]
        HeroNode [no=3, name=吴用, nickname=智多星]
        HeroNode [no=4, name=林冲, nickname=豹子头]
        插入末尾后情况~~
        HeroNode [no=1, name=宋江, nickname=及时雨]
        HeroNode [no=2, name=卢俊义, nickname=玉麒麟]
        HeroNode [no=3, name=吴用, nickname=智多星]
        HeroNode [no=4, name=林冲, nickname=豹子头]
        HeroNode [no=5, name=last, nickname=队尾]
        插入队首后情况~~
        HeroNode [no=5, name=first, nickname=队首]
        HeroNode [no=1, name=宋江, nickname=及时雨]
        HeroNode [no=2, name=卢俊义, nickname=玉麒麟]
        HeroNode [no=3, name=吴用, nickname=智多星]
        HeroNode [no=4, name=林冲, nickname=豹子头]
        HeroNode [no=5, name=last, nickname=队尾]
        指定位置后的链表情况~~
        HeroNode [no=5, name=first, nickname=队首]
        HeroNode [no=1, name=宋江, nickname=及时雨]
        HeroNode [no=2, name=卢俊义, nickname=玉麒麟]
        HeroNode [no=3, name=吴用, nickname=智多星]
        HeroNode [no=5, name=center, nickname=中间]
        HeroNode [no=4, name=林冲, nickname=豹子头]
        HeroNode [no=5, name=last, nickname=队尾]
        
  - 约瑟夫环 CircleSingleLinkedList
  - 数组模拟栈，计算表达式的值ArrayStack2 
    - 前缀表达式：波兰表达式。运算符位于操作数之前. 
        - 比如 -*+ 3456。
        - 规则是：从右向左进行扫描。遇到数字压入栈，遇到符号，弹出栈顶的两个数进行计算后，结果再入栈。
    - 中缀表达式：(3 +4)*5-6。常见的写法
    - 后缀表达式：逆波兰表达式。运算符在操作数之后 
      -   规则：从左到右进行扫描。遇到数字压入栈。遇到符号，弹出栈顶的两个数进行计算后，结果入栈。
        - 比如：34+5*6-
        - a+b-->ab+
        - a+(b-c)--> abc-+
        - a-(b-c)*d--> abc-d*+
        - a+d*(b-c)--> adbc-*+
        - a=1+3--> a13+=
        
        
        
        
        
        
        
        
        
        
        
        
        
        