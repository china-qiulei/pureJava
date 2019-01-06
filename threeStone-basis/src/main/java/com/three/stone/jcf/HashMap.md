- 通过hash & (table.length -1)来得到该对象的保存位，而HashMap底层数组的长度总是2的n次方(默认是16)，这是HashMap在速度上的优化。
当length总是2的n次方时，h& (length-1)运算等价于对length取模，也就是h%length，但是&比%具有更高的效率。

```
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    tab[(length - 1) & hash]
```