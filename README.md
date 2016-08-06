### android-aidl-2 可能是多module版的最简单的aidl的实现
#### 介绍
* 多module和单module其实在aidl的实现上没有本质的区别
* 可能是单module的最简单的aidl实现[传送门](https://github.com/duckAndroid/-android-aidl-/tree/master)
* 多`module`之间进行`aidl`的注意事项：`pojo`对象定义在哪个`module`？定义在`aidl`所在`module`即可。
* 更多介绍，详见`Wiki`

--------------------------

#### 实现
* 实现多`module`之间，简单传递是单向传递。 service-->client。 详见 `tag v1.0`
* 实现多`module`之间，`pojo`对象的双向传递。 service <-->client。 详见 `tag v1.1`
* 实现多`module`之间，基本类型数据的双向传递。是对`tag v1.0`的完善。 详见 `tag v2.0`

------------------------------------------

* 不清楚什么原因，貌似github的访问越来越受限了。
