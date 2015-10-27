/**
 * Created by LY on 2015/4/17.
 */

class  People
{
  var  name:String="zhangmiao"
  var age:Int = 0

  def this(name :String)=   //辅助构造器
  {
    this()
    this.name=name
  }
  def this(name :String ,age :Int)=
  {
    this(name)
    this.age=age
  }

  def show(test:People)=
  {
    println(test.name+" "+ test.age)
  }

  def discroption=name+" is "+age+" years old !"
}

object  People  //类的伴生对象
{
  def main(args:Array[String])=
  {
    val people1=new People
    val people2=new People("liuyu")
    val people3=new People("yuanshuai",18)
    people1.show(people1)
    people2.show(people2)
    println (people2.discroption)
    people3.show(people3)

    val array1=Array(100)
    println(array1)
  }
}