如何使用@ConditionXXX 系列注解来更方便地实现这种策略选择的场景。
@ConditionXXX 系列注解是 Spring 提供的一组注解，下面表格列出所有的注解以及对应的作用，常用的注解通过☆标注
上文中的例子中，多个策略同一个环境其实只需要加载一个适合的策略即可，完全没有必要加载用不上的其他策略，在系统启动时，只取所需的策略就足矣，实现起来相较于策略模式方便不是一点点。
常用注解:

注解	作用	常用
@ConditionalOnProperty	当指定的属性有指定的值时进行实例化	☆
@ConditionalOnMissingBean	当容器里没有指定 Bean 的条件下进行实例化。	☆
@ConditionalOnExpression	基于 SpEL 表达式的条件判断，多条件	☆
@ConditionalOnBean	仅仅在当前上下文中存在某个对象时，才会实例化一个 Bean。	
以不同环境发送短信为例，进行代码实现 (当然这个例子有点强上的异味，不过用于来解释这几个主键的功用却是很合适，具体应用场景请触类旁通)。