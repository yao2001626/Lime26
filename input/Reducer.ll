; ModuleID = '/Users/shucaiyao/eclipse-workspace/Lime26/input/Reducer.c'
source_filename = "/Users/shucaiyao/eclipse-workspace/Lime26/input/Reducer.c"
target datalayout = "e-m:o-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-apple-macosx10.12.0"

%struct.Reducer_struct = type { i32, i32, i32, i32, i32, %struct.Reducer_struct*, i32, i32, i32, i32 }

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @Reducer_reduce1(i32, %struct.Reducer_struct*, i8*) #0 {
  %4 = alloca i32, align 4
  %5 = alloca %struct.Reducer_struct*, align 8
  %6 = alloca i8*, align 8
  store i32 %0, i32* %4, align 4
  store %struct.Reducer_struct* %1, %struct.Reducer_struct** %5, align 8
  store i8* %2, i8** %6, align 8
  %7 = load i32, i32* %4, align 4
  %8 = load %struct.Reducer_struct*, %struct.Reducer_struct** %5, align 8
  %9 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %8, i32 0, i32 8
  store i32 %7, i32* %9, align 8
  %10 = load %struct.Reducer_struct*, %struct.Reducer_struct** %5, align 8
  %11 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %10, i32 0, i32 6
  store i32 1, i32* %11, align 8
  ret void
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @Reducer_reduce2(i32, %struct.Reducer_struct*, i8*) #0 {
  %4 = alloca i32, align 4
  %5 = alloca %struct.Reducer_struct*, align 8
  %6 = alloca i8*, align 8
  store i32 %0, i32* %4, align 4
  store %struct.Reducer_struct* %1, %struct.Reducer_struct** %5, align 8
  store i8* %2, i8** %6, align 8
  %7 = load i32, i32* %4, align 4
  %8 = load %struct.Reducer_struct*, %struct.Reducer_struct** %5, align 8
  %9 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %8, i32 0, i32 9
  store i32 %7, i32* %9, align 4
  %10 = load %struct.Reducer_struct*, %struct.Reducer_struct** %5, align 8
  %11 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %10, i32 0, i32 7
  store i32 1, i32* %11, align 4
  ret void
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @Reducer_doReduce(%struct.Reducer_struct*, i8*) #0 {
  %3 = alloca %struct.Reducer_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Reducer_struct* %0, %struct.Reducer_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %5, i32 0, i32 4
  %7 = load i32, i32* %6, align 8
  %8 = icmp eq i32 %7, 1
  br i1 %8, label %9, label %21

; <label>:9:                                      ; preds = %2
  %10 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %11 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %10, i32 0, i32 8
  %12 = load i32, i32* %11, align 8
  %13 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %14 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %13, i32 0, i32 9
  %15 = load i32, i32* %14, align 4
  %16 = add nsw i32 %12, %15
  call void @print(i32 %16)
  %17 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %18 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %17, i32 0, i32 8
  store i32 0, i32* %18, align 8
  %19 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %20 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %19, i32 0, i32 9
  store i32 0, i32* %20, align 4
  br label %52

; <label>:21:                                     ; preds = %2
  %22 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %23 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %22, i32 0, i32 4
  %24 = load i32, i32* %23, align 8
  %25 = srem i32 %24, 2
  %26 = icmp eq i32 %25, 0
  br i1 %26, label %27, label %39

; <label>:27:                                     ; preds = %21
  %28 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %29 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %28, i32 0, i32 8
  %30 = load i32, i32* %29, align 8
  %31 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %32 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %31, i32 0, i32 9
  %33 = load i32, i32* %32, align 4
  %34 = add nsw i32 %30, %33
  %35 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %36 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %35, i32 0, i32 5
  %37 = load %struct.Reducer_struct*, %struct.Reducer_struct** %36, align 8
  %38 = load i8*, i8** %4, align 8
  call void @Reducer_reduce1(i32 %34, %struct.Reducer_struct* %37, i8* %38)
  br label %51

; <label>:39:                                     ; preds = %21
  %40 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %41 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %40, i32 0, i32 8
  %42 = load i32, i32* %41, align 8
  %43 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %44 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %43, i32 0, i32 9
  %45 = load i32, i32* %44, align 4
  %46 = add nsw i32 %42, %45
  %47 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %48 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %47, i32 0, i32 5
  %49 = load %struct.Reducer_struct*, %struct.Reducer_struct** %48, align 8
  %50 = load i8*, i8** %4, align 8
  call void @Reducer_reduce2(i32 %46, %struct.Reducer_struct* %49, i8* %50)
  br label %51

; <label>:51:                                     ; preds = %39, %27
  br label %52

; <label>:52:                                     ; preds = %51, %9
  %53 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %54 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %53, i32 0, i32 6
  store i32 0, i32* %54, align 8
  %55 = load %struct.Reducer_struct*, %struct.Reducer_struct** %3, align 8
  %56 = getelementptr inbounds %struct.Reducer_struct, %struct.Reducer_struct* %55, i32 0, i32 7
  store i32 0, i32* %56, align 4
  ret void
}

declare void @print(i32) #1

attributes #0 = { noinline nounwind optnone ssp uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0, !1}
!llvm.ident = !{!2}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 7, !"PIC Level", i32 2}
!2 = !{!"clang version 5.0.0 (tags/RELEASE_500/final)"}
