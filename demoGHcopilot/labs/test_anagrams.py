import pytest
from anagrams import are_anagrams


class TestAnagrams:
    """Test cases for the are_anagrams function."""

    def test_basic_anagrams_lowercase(self):
        """Test basic anagrams with lowercase letters."""
        assert are_anagrams("listen", "silent") == True
        assert are_anagrams("evil", "vile") == True

    def test_basic_anagrams_mixed_case(self):
        """Test anagrams with mixed case letters."""
        assert are_anagrams("Listen", "Silent") == True
        assert are_anagrams("EVIL", "vile") == True
        assert are_anagrams("Dormitory", "Dirty Room") == True

    def test_anagrams_with_spaces(self):
        """Test anagrams that contain spaces."""
        assert are_anagrams("conversation", "voices rant on") == True
        assert are_anagrams("the eyes", "they see") == True
        assert are_anagrams("a gentleman", "elegant man") == True

    def test_not_anagrams_same_length(self):
        """Test strings of same length that are not anagrams."""
        assert are_anagrams("hello", "world") == False
        assert are_anagrams("python", "java  ") == False

    def test_not_anagrams_different_length(self):
        """Test strings of different lengths."""
        assert are_anagrams("short", "longer") == False
        assert are_anagrams("cat", "cats") == False
        assert are_anagrams("hello", "hi") == False

    def test_empty_strings(self):
        """Test edge case with empty strings."""
        assert are_anagrams("", "") == True
        assert are_anagrams("", "a") == False
        assert are_anagrams("a", "") == False

    def test_single_character(self):
        """Test edge case with single characters."""
        assert are_anagrams("a", "a") == False
        assert are_anagrams("a", "b") == False
        assert are_anagrams("A", "a") == True

    def test_identical_strings(self):
        """Test identical strings (should not be anagrams)."""
        assert are_anagrams("hello", "hello") == False
        assert are_anagrams("Python", "Python") == False
        assert are_anagrams("test case", "test case") == False

    def test_strings_with_repeated_characters(self):
        """Test anagrams with repeated characters."""
        assert are_anagrams("aab", "aba") == True
        assert are_anagrams("aab", "baa") == True
        assert are_anagrams("aabbcc", "abcabc") == True
        assert are_anagrams("aab", "aaa") == False

    def test_special_characters_and_numbers(self):
        """Test strings containing special characters and numbers."""
        assert are_anagrams("a1b2c3", "3c2b1a") == True
        assert are_anagrams("hello!", "!olleh") == True
        assert are_anagrams("test@123", "123@tset") == True
        assert are_anagrams("a!b@c#", "c#a!b@") == True
        assert are_anagrams("hello!", "hello?") == False


# Additional test cases using pytest parametrize for cleaner code
@pytest.mark.parametrize("str1,str2,expected", [
    # True anagram cases
    ("race", "care", True),
    ("stressed", "desserts", True),
    ("night", "thing", True),
    ("cinema", "iceman", True),
    
    # False anagram cases  
    ("hello", "bello", False),
    ("python", "java", False),
    ("test", "best", False),
    ("anagram", "not anagram", False),
])
def test_anagrams_parametrized(str1, str2, expected):
    """Parametrized tests for additional coverage."""
    assert are_anagrams(str1, str2) == expected


if __name__ == "__main__":
    pytest.main([__file__])
