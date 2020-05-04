from typing import Tuple


def linear_search(sorted_list: list, value: int) -> Tuple[bool, int]:

    for i in range(0, len(sorted_list)):
        if sorted_list[i] == value:
            return True, i

    return False, -1


def jump_search(sorted_list: list, value: int, step_size: int) -> Tuple[bool, int]:

    for i in range(0, len(sorted_list), step_size):
        if sorted_list[i] > value:
            for j in range(i - step_size, i):
                if sorted_list[j] == value:
                    return True, j
            return False, -1

    for k in range(len(sorted_list) - step_size, len(sorted_list)):
        if sorted_list[k] == value:
            return True, k

    return False, -1


def binary_search(ordered_list: list,n: int):
    lower_bound = 0
    upper_bound = len(ordered_list) - 1

    while lower_bound <= upper_bound:
        middle_bound = lower_bound + (upper_bound - lower_bound) // 2
        posible_val = ordered_list[middle_bound]
        if posible_val == n: 
            return middle_bound
        elif n < posible_val:
            upper_bound = middle_bound - 1
        else: 
            lower_bound = middle_bound + 1
    return None 


