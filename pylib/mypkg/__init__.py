# -*- coding: utf-8 -*-
"""
_mypkg/__init__py
"""
try:
    import os
    import _mypkg_foo
    __path__.append(os.path.abspath(os.path.dirname(_mypkg.foo.__file__)))
    
except ImportError:
    print("_mypkg_foo import error")

