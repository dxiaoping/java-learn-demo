# Spring 加载流程
## 初始类加载
* 创建 ApplicationContext
    * 创建 AnnotatedBeanDefinitionReader
      * registerAnnotationConfigProcessors 优先加载内置处理器（internal前缀标识）
        1. ConfigurationClassPostProcessor.class
        2. AutowiredAnnotationBeanPostProcessor.class
        3. CommonAnnotationBeanPostProcessor.class
        4. EventListenerMethodProcessor.class
        5. DefaultEventListenerFactory.class
    * 创建 ClassPathBeanDefinitionScanner
## 配置类加载
## BeanDefinition加载
## Bean实例化
