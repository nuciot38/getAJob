#sliding windows

### 1.最大连续1的个数

######	返回仅包含1的最长（连续）子数组的长度给定一个由若干0和1组成的数组 A，我们最多可以将 K 个值从0变成1。返回仅包含 1 的最长（连续）子数组的长度。

###### 思路：

###### 	1.当数组为空时，子数组长度为0；

###### 	2.当数组的长度小于等于K时，子数组长度等于当前数组长度

###### 	3.子数组长度等于窗口长度即1和K个0

	######			3.1定义left和right，right和left之间的距离即为滑动窗口的宽度

	######			3.2当前数组中的数为1时，right++

	######			3.3当前数组中的数为0时：

		###### 					3.3.1当K>0时，right++，K--

		###### 					3.3.2当K=0时，left++至数组中的数字为0，此时left++，将窗口left的0清出窗口，right++，将窗口右侧的0加入窗口
