def algorithm_1(vector_1:list[int], vector_2:list[int]) -> int:
    n = len(vector_1)
    m = len(vector_2)
    if(m != n):
        return None
    result = 0
    for i in range(n):
        result += vector_1[i] * vector_2[i]
    return result

list_1 = [1,2,3,4,5]
list_2 = [1,2,3,4,5]
    
result = algorithm_1( list_1, list_2)
print(result)

def algorithm_2(input_list:list[int]) -> int:
    n = len(input_list)
    max = input_list[0]
    for i in range(n): 
        sum = 0
        for j in range(n):
            sum += input_list[j]
            if sum > max:
                max = sum 
    return max

result2 = algorithm_2(list_1)
print(result2)