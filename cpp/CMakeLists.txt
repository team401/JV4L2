cmake_minimum_required(VERSION 3.8)
project(JV4L2)

set(CMAKE_C_STANDARD 99)

find_package(JNI REQUIRED)
include_directories(${JNI_INCLUDE_DIRS})

include(cmake/FindV4L2.cmake)

set(SOURCE_FILES JV4L2.c org_jv4l2_Jv4l2JNI.h)
add_library(JV4L2 SHARED ${SOURCE_FILES})
target_link_libraries(JV4L2 ${LIBV4L2_LIBRARY})