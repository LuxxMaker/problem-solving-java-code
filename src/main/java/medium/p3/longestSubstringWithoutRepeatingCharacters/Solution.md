# 3. Longest Substring Without Repeating Characters

## Problem Description
Given a string s, find the length of the longest
substring
without repeating characters.

Example 1:

    Input: s = "abcabcbb"    
    Output: 3      
    Explanation: The answer is "abc", with the length of 3.     
    Example 2:     

Example 2: 

    Input: s = "bbbbb"     
    Output: 1     
    Explanation: The answer is "b", with the length of 1.     
    Example 3:     

Example 3:

    Input: s = "pwwkew"     
    Output: 3     
    Explanation: The answer is "wke", with the length of 3.     
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.     
     

## Solution

해당 문제는 윈도우 슬라이딩 기법을 이용해서 해결할 수 있다. 윈도우 슬라이딩 기법은 특정 범위의 값을 이동하면서 그 범위 내에서 원하는 조건을 만족하는 값을 찾는 방법이다. 


### Try 1 

```java
public int lengthOfLongestSubstring2(String s) {
    int resultCount = 0;
    // String.charAt을 반복해서 호출하기 보다는 char[]로 변환해서 배열 접근을 이용했다.
    char[] chars = s.toCharArray();
    int from = 0, to;

    int len = s.length();
    
    // HashSet을 이용해서 각 글자들을 저장하고, 중복되었는지 여부를 확인한다.
    HashSet<Character> cache = new HashSet<>();

    for (to = 0; to < len; to++) {
        char one = chars[to];

        if (cache.contains(one)) {
            // 중복이 발생할 때맏 길이를 계산한다.
            resultCount = Math.max(resultCount, to - from);

            // HashSet에는 각 글자들만 저장하기 때문에 만약에 중복이 발생하면 
            // 중복된 글자가 사라질 때까지 이동하고 HashSet을 업데이트한다.
            // 중복된 글자가 있어서 들어온 것이기 때문에 반드시 prevOne == one은 발생한다. 
            while (true) {
                char prevOne = chars[from++];
                if (prevOne == one) break;
                cache.remove(prevOne);
            }
        } else {
            // 중복된 부분이 없기 때문에 길이 계산을 하지 않고 바로 넘어간다. 
            cache.add(one);
        }
    }

    // 만약 마지막 순회에서 반복이 발생하지 않을 경우에는 loop를 벗어나서 1번만 확인
    // 반복적인 length 업데이트를 최소화했다.
    return Math.max(resultCount, to - from);
}
```

- 입력된 문자를 char[] 로 만드는데 O(n)
- start 포인터, end 포인터 각각 한번씩만 순회하기 때문에 O(n)
- 따라서 전체적인 시간 복잡도는 O(n) 이다. 



### Try 2

기본적으로 윈도우 슬라이딩 기법을 사용한 것은 동일하다. 하지만 HashSet을 사용하지 않았고, 중복된 글자를 고려해서 마지막 인덱스를 배열에 저장하는 방식이다.

이전의 시도에서는 while(true) 로 start도 이동하면서 중복 문자열까지 HashSet 값을 지워주는 로직이 있었던 것에 반해서 이 코드에서는 그러한 부분없이 바로 캐시된 인덱스로 연산하는 것이 특징이다. 

모든 순회에 대해서 lastIndex 라는 캐시 배열에 업데이트를 전부 실행하지만, start도 계속 이동하면서 캐시하는 연산은 사라지며, 코드 자체도 좀더 간결해졌다. 

```java
public int lengthOfLongestSubstring(String s) {
    int maxLength = 0, sLength = s.length();
    // 입력값에 알파벳 & 숫자 & 기호값까지 포함하다보니 128 까지 생성한다. 
    int[] lastIndex = new int[128];

    for (int end = 0, start = 0; end < sLength; end++) {
        char currentChar = s.charAt(end);
        
        // end가 나타나는 문자가 
        // start 보다 뒤쪽에 있는 문자가 
        // 1. 1번째로 나타난 경우 ; start가 lastIndex[currentChar]보다 크다. 
        // 2. 2번째로 나타난 경우 : lastIndex[currentChar]가 start보다 더 크다.
        // start는 중복이 아니라면 계속 유지되고, 중복이 나타나면 그 중복 문자 위치 + 1 만큼 이동해서 length 를 계산할수 있게 된다. 
        start = Math.max(lastIndex[currentChar], start);
        
        // + 1 하는 이유는 자기 자신을 포함해서 길이를 계산하기 때문이다.
        maxLength = Math.max(maxLength, end - start + 1);
        
        // lastIndex[currentChar] 를 가지고 와서 사용되는 시점은 반드시 중복 문자열이 나타난 상황이다. 
        // 아니라면 처음 start = 0 인 상황에서 사실상 변경될 일이 없다.
        // 중복 문자열이 나타났을때 이전 중복 문자열의 위치를 사용해선 안된다. 이미 중복이기 때문
        // 따라서 그 값보다 + 1 이동해서 해야 한다. 
        // 만약 www 이런 문자가 있다고 할지라도 +1 위치이동하기 때문에 사실상 길이 1짜리로 계산된다. 
        lastIndex[currentChar] = end + 1;
    }

    return maxLength;
}
```





