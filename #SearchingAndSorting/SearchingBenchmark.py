from Searching import binary_search, linear_search, jump_search

def test_binary_search(benchmark):
    L = list(range(0,1000))
    res = benchmark(binary_search,L,71)
    assert res == 71

def test_linear_search(benchmark):
    L = list(range(0,1000))
    res = benchmark(linear_search,L,45)

def test_jump_search(benchmark):
    L = list(range(0,1000))
    res = benchmark(jump_search,L,52,3)
