# Практическое задание №2

С помощью *Eclipse IDE* разработать консольное Java-приложение.

## Требования

:one: **Проект** должен называться `Practice2`.

:two: **Корневой** пакет для всех классов: `ua.nure.your_last_name.practice2`.

:three: **Соблюдать** [Java Code Conventions](http://www.oracle.com/technetwork/java/codeconventions-150003.pdf).

:four: **Запрещено** использовать любые типы из пакета `java.util`, кроме двух:

- `java.util.Iterator`
- `java.util.NoSuchElementException`

## 0. Создать и расположить в корневом пакете интерфейс `Container`

```java
package ua.nure.your_last_name.practice2;

public interface Container extends Iterable<Object> {
	
	// Removes all of the elements.
	void clear();

	// Returns the number of elements.
	int size();
	
	// Returns a string representation of this container.
	String toString();

	// Returns an iterator over elements.
	// Iterator must implements the remove method.
	Iterator<Object> iterator();

}
```

## 1. Создать интерфейс `Queue` следующего содержания

```java
package ua.nure.your_last_name.practice2;

public interface Queue extends Container {

	// Appends the specified element to the end.
	void enqueue(Object element);

	// Removes the head.
	Object dequeue();

	// Returns the head.
	Object top();

}
```

## 2. Создать класс `QueueImpl`, который реализует интерфейс `Queue`

Если в контейнер были добавлены три элемента **A, B, C** с помощью метода `enqueue`

1. Метод `toString` должен возвращать строку `[A, B, C]`

2. Порядок обхода элементов контейнера итератором: *A B C*

## 3. В классе `QueueImpl` создать метод `main`, в котором продемонстрировать

1. Работу всех методов интерфейса `Queue` (включая унаследованные от `Container` и `Iterable`).

2. Работу всех методов интерфейса `Iterator` *(hasNext/next/remove)*.

# Вопросы

1. Что такое перекрытие, перегрузка, сокрытие метода.
2. Что такое наследование, ключевые слова *implements*, *extends*.
3. Какие типы не могут быть наследованы?
4. Ограничения при перекрытии метода.
5. Что такое инкапсуляция, для чего она предназначена, как ее реализовать.
6. Контексты использования ключевого слова *final*.
7. Порядок вызова конструкторов, блоков инициализации при создании объекта.
8. Анонимные классы.
9. В чем отличие вложенных классов от внутренних.

---

Нижеследующий класс может быть использован для тестирования основного кода. Необходимо обеспечить выполнение тестов.

```java
package ua.nure.your_last_name.practice2;

import java.util.Iterator;

public class QueueTests {
	
	public static void main(String[] args) {
		test1();
		test2();
		// ...
	}
	
	public static void test1() {

		Queue queue = new QueueImpl();
		Class c = queue.getClass();

		// must be 1
		System.out.println(c.getInterfaces().length);

		// must be Queue
		System.out.println(c.getInterfaces()[0].getSimpleName());

		// must be 1
		System.out.println(c.getInterfaces()[0].getInterfaces().length);

		// must be Container
		System.out.println(c.getInterfaces()[0].getInterfaces()[0].getSimpleName());

		// must be 1
		System.out.println(c.getInterfaces()[0].getInterfaces()[0].getInterfaces().length);

		// must be java.lang.Iterable
		System.out.println(c.getInterfaces()[0].getInterfaces()[0].getInterfaces()[0].getName());

		/* an output must be as the following:
		*************************************
		1
		Queue
		1
		Container
		1
		java.lang.Iterable
		*************************************
		*/
	}

	public static void test2() {

		Queue queue = new QueueImpl();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		System.out.println(queue);
		System.out.println(queue.size());

		queue.clear();
		System.out.println(queue);
		System.out.println(queue.size());

		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		System.out.println(queue);
		System.out.println(queue.size());

		/* an output must be as the following:
		*************************************
		[A, B, C]
		3
		[]
		0
		[A, B, C]
		3
		*************************************
		*/
	}

	public static void test3() {

		Queue queue = new QueueImpl();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		System.out.print(queue.dequeue());
		System.out.print(queue.dequeue());
		System.out.print(queue.dequeue());
		System.out.println();
		System.out.print(queue);

		/* an output must be as the following:
		*************************************
		ABC
		[]
		*************************************
		*/
	}

	public static void test4() {

		Queue queue = new QueueImpl();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		for (Object element : queue) {
			System.out.print(element);
		}

		/* an output must be as the following:
		*************************************
		ABC
		*************************************
		*/
	}

	public static void test5() {

		Queue queue = new QueueImpl();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		Iterator it = queue.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		it = queue.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}

		/* an output must be as the following:
		*************************************
		ABC
		ABC
		*************************************
		*/
	}

	public static void test6() {

		Queue queue = new QueueImpl();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		Iterator it = queue.iterator();
		System.out.println(it.next());
		it.remove();
		System.out.println(it.next());
		it.remove();
		System.out.println(it.next());
		it.remove();
		System.out.println(queue);

		/* an output must be as the following:
		*************************************
		A
		B
		C
		[]
		*************************************
		*/
	}

	public static void test7() {

		Queue queue = new QueueImpl();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		Iterator it = queue.iterator();

		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		it.remove();
		System.out.println(queue);

		it = queue.iterator();

		System.out.println(it.next());
		it.remove();
		System.out.println(queue);

		it = queue.iterator();

		System.out.println(it.next());
		it.remove();
		System.out.println(queue);

		/* an output must be as the following:
		*************************************
		A
		B
		C
		[A, B]
		A
		[B]
		B
		[]
		*************************************
		*/
	}

	public static void test8() {

		Queue queue = new QueueImpl();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		Iterator it = queue.iterator();
		System.out.println(it.next());
		it.remove();
		try {
			it.remove();
		} catch (IllegalStateException ex) {
			System.out.println("exception");
		}

		/* an output must be as the following:
		*************************************
		A
		exception
		*************************************
		*/
	}

	public static void test9() {

		Queue queue = new QueueImpl();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		Iterator it = queue.iterator();
		try {
			it.remove();
		} catch (IllegalStateException ex) {
			System.out.println("exception");
		}

		/* an output must be as the following:
		*************************************
		exception
		*************************************
		*/
	}

	public static void test10() {

		Queue queue = new QueueImpl();
		queue.enqueue("A");
		queue.enqueue("B");
		System.out.println(queue.top());

		/* an output must be as the following:
		*************************************
		A
		*************************************
		*/
	}

}
```