package java.util;
import checkers.igj.quals.*;

@I
public interface SortedMap<K, V> extends @I Map<K, V> {
  public abstract @ReadOnly Comparator<? super K> comparator(@ReadOnly SortedMap this);
  public abstract @I SortedMap<K, V> subMap(@ReadOnly SortedMap this, K a1, K a2);
  public abstract @I SortedMap<K, V> headMap(@ReadOnly SortedMap this, K a1);
  public abstract @I SortedMap<K, V> tailMap(@ReadOnly SortedMap this, K a1);
  public abstract K firstKey(@ReadOnly SortedMap this);
  public abstract K lastKey(@ReadOnly SortedMap this);
  public abstract @I Set<K> keySet(@ReadOnly SortedMap this);
  public abstract @I Collection<V> values(@ReadOnly SortedMap this);
  public abstract @I Set<@I Map.Entry<K, V>> entrySet(@ReadOnly SortedMap this);
}
