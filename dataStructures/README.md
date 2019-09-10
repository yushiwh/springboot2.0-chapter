
- 注意test里面更改后需要重新的mvn install 一下
## 数据结构

- 稀疏数组（Sparsearray）
  （行不固定，列固定3列。第一行是行数、列数、有效数据个数。真正的数据记录是从第二行开始）
- 二维数组转稀疏数组的思路 
1.遍历 原始的二维数组，得到有效的数据的个数
2. 根据sum就可以创建稀疏数组 int[sum+1][3]。（稀疏数组的列固定为3列） 
3. 将二维数组中有效数据存放进稀疏数组里面。（对应的行号、列号、值）

```

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

```

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
    -  //完成对逆波兰表达式的运算 
       1. 从左至右扫描，将3和4压入堆栈；
       2. 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
       3. 将5入栈；	
       4. 接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈； 
       5. 将6入栈； 
       6. 最后是-运算符，计算出35-6的值，即29，由此得出最终结果 */
        
    - 中缀表达式转换后缀表达式步骤PolandNotation中的parseSuffixExpreesionList方法，注意先要转换成对应的list（toInfixExpressionList方法）
    - 完整的逆波兰表达式的计算器，支持小数点和空格符等ReversePolishMultiCalc
     
        
-  递归（Recursive）
        
-  排序（8种） 
        - 插入排序 直接插入 InsertSort 
        - 希尔排序 ShellSort（插入排序的升级版本，防止出现最小的在最后的情况）
   - 选择排序 
        -  简单选择排序 SelectSort 
        -  堆排序（跟二叉树相关）
   - 交换排序 
        - 冒泡排序 bubbleSort 
        - 快速排序 QuickSort （递归，冒泡的升级版本，空间换时间，时间很快）
   - 归并排序 (速度跟快速排序差不多，也很快)(MergetSort)
   - 桶排序BarrelSort   速度也非常快，但是因为要创建一些多余的桶，浪费空间。所以出现基数排序，升级版本
   - 基数排序 (非常快，但是可能会内存溢出。因为是空间换时间)（RadixSort）将整数按照位数进行切割成不同的数字，然后按照每个位数分别比较。很神奇
- 算法的时间复杂度
  - 时间频度：一个算法花费的时间与算法中语句的执行的次数成正比，那个算法语句中执行的次数多，那就花费时间多。
    - 一个算法中语句执行的次数成为时间频度。
        


- 查找算法
  - 顺序（线性）查找 seqSearch
  - 二分查找/折半查找 BinarySearch
  - 插值查找 二分查找的升级版本 InsertValueSearch，查找中间值的算法比较牛逼
  - 斐波那契查找（黄金分割点）  FibonacciSearch

- hash算法 HashTable












        
        