from random import sample 
from Sorting import quick_sort
from Sorting import selection_sort
from Sorting import bubble_sort

unsorted_list = sample(range(1, 1000), 999)
sorted_list = list(range(1, 1000))

def test_quick_sort(benchmark):
    unsorted_list = sample(range(1, 1000), 999)
    benchmark(quick_sort,unsorted_list)

def test_selection_sort(benchmark):
    result = benchmark(selection_sort, unsorted_list)
    assert result == sorted_list

def test_bubble_sort(benchmark):
    result = benchmark(bubble_sort, unsorted_list)
    assert result == sorted_list
