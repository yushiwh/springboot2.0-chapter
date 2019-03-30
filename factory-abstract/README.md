抽象工厂模式


对应的角色
 ● AbstractFactory（抽象工厂）：它声明了一组用于创建一族产品的方法，每一个方法对应一种产品。
 ● ConcreteFactory（具体工厂）：它实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。
 ● AbstractProduct（抽象产品）：它为每种产品声明接口，在抽象产品中声明了产品所具有的业务方法。
 ● ConcreteProduct（具体产品）：它定义具体工厂生产的具体产品对象，实现抽象产品接口中声明的业务方法。
 
 
 抽象产品--->具体产品
 1.Button-->SpringButton、SummerButton
 2.Combox-->SpringCombox、SummerCombox
 3.TextField-->SpringTextField、SummerTextField
 
 抽象工厂-->具体工厂
 1.SkinFactory -->SpringSkinFactory、SummerSkinFactory
 
 可以根据配置文件进行配置
 