def are_anagrams(str1, str2):
    """
    Check if two strings are anagrams of each other.
    
    Args:
        str1: First string
        str2: Second string
    
    Returns:
        bool: True if strings are anagrams, False otherwise
    """
    # Exclude same words
    if str1 == str2:
        return False
    
    # Remove spaces and convert to lowercase
    str1 = str1.replace(" ", "").lower()
    str2 = str2.replace(" ", "").lower()
    
    # Check if lengths are different
    if len(str1) != len(str2):
        return False
    
    # Sort characters and compare
    return sorted(str1) == sorted(str2)
