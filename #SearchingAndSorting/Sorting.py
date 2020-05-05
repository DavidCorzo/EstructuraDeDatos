def selection_sort(unsorted: list) -> list:

    for i in range(0, len(unsorted) - 1):
        min = i

        for j in range(i + 1, len(unsorted)):
            if unsorted[j] < unsorted[min]:
                min = j

        if min != i:
            unsorted[i], unsorted[min] = unsorted[min], unsorted[i]

    return unsorted

def bubble_sort(unsorted: list) -> list:

    for i in range(0, len(unsorted)):
        for j in range(0, len(unsorted) - 1 - i):
            if unsorted[j] > unsorted[j + 1]:
                unsorted[j], unsorted[j + 1] = unsorted[j + 1], unsorted[j]

    return unsorted

def quick_sort(unordered_list: list) -> list:
    lenght = len(unordered_list)
    if lenght <= 1:
        return unordered_list
    else: # the last element is poped
        pivot = unordered_list.pop()
    upper, lower = list(), list()
    for item in unordered_list:
        if item > pivot: 
            upper.append(item)
        else:
            lower.append(item)
    return quick_sort(lower) + [pivot] + quick_sort(upper) 

# def main():
#     L = [3,5,4,1,7,9,10]
#     l = quick_sort(L)
#     print(l)
# if __name__ == "__main__":
#     main()
