package firstScala

/**
 * Created by LY on 2015/1/11.
 */

class firstTest
{
    val age=29
    var name=""
}

class  person
{
    var email="12334354@qq.com"   //var声明可变变量,生成getter和setter
    var name=""   //_起到占位符的作用
    val age=34   //val声明常变量，val只生成gette
    private  val gender="male"  //private声明的只在类内部起作用

    //val test=if(gender=="male") 1 else 0
}

object firstTest
{
    def add=(x:Int,y:Int) =>x+y
    def  add1(x:Int)(y:Int)=x+y
    def hello=
    {
      print(1+12)
    }

    def fun(name : String="scala"):String =
    {
       "name;"+name
    }

    def main(args:Array[String])
    {
      println("Hello scala!")
      println(add(1,4))

      for(i<-1 to 10 if i%2==0)
      println(i)

      val scala1=new firstTest  //初始化一个类实例
      scala1.name="liuyu"
      println(scala1.name+"今年"+scala1.age+"岁了！")

      hello //无参函数函数，可使用函数名直接调用
      println()

      println(add1(12)(12))

      println(fun("JAVA"))

      var (n,r)=(10,0)
      while(n>0)  //在scala中没有置前或置后自增及自减
      {
        r+=n
        n-=1
      }
      println(r)

      args.foreach(println)

      val number=new Array[String](2)
      number(0)="hello"
      number(1)="nihao"
      println(number(1))

      val numName=Array("liuyu","sunfang","lvcheng")//Array的长度不可变，但是值可变
      for (m <- 0 to numName.length-1)
        println(numName(m))

      val list1=List(1,2,2)
      list1.foreach(a=>println(a))

      println("List ru xia:")
      val list2 =List(3,4,5)
      val list3=list2:::list1   //:::符号用来连接两个List
      list3.foreach(println)

      val list4=0::list3 //:: 右操作符号，将一个新元素放在List的最前边
      list4.foreach(println)

      val ly=new person
      ly.name="ly"
      println(ly.name+" year "+ly.age+" sui "+ly.email+" ! ")
    }
}
