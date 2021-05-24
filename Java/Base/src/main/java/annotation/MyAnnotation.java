package annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/*
* 3. 如何自定义注解：参照@SuppressWarnings定义
* ① 注解声明为：@interface
* ② 内部定义成员，通常使用value表示
* ③ 可以指定成员的默认值，使用default定义
* ④ 如果自定义注解没有成员，表明是一个标识作用。

    如果注解有成员，在使用注解时，需要指明成员的值。
    自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
    自定义注解通过都会指明两个元注解：Retention、Target
*/

/*
4. jdk 提供的4种元注解
元注解：对现有的注解进行解释说明的注解
Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS（默认行为）\RUNTIME
           只有声明为RUNTIME生命周期的注解，才能通过反射获取。
Target:用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 *******出现的频率较低*******
Documented:表示所修饰的注解在被javadoc解析时，保留下来。
Inherited:被它修饰的 Annotation 将具有继承性。
*/
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {

    String value() default "hello";
}
