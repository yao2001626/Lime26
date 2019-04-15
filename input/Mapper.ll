; ModuleID = '/Users/shucaiyao/eclipse-workspace/Lime26/input/Mapper.c'
source_filename = "/Users/shucaiyao/eclipse-workspace/Lime26/input/Mapper.c"
target datalayout = "e-m:o-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-apple-macosx10.12.0"

%struct.Mapper_struct = type { i32, i32, i32, i32, %struct.Reducer_struct*, i32, i32, i32 }
%struct.Reducer_struct = type opaque

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @Mapper_map(i32, %struct.Mapper_struct*, i8*) #0 {
  %4 = alloca i32, align 4
  %5 = alloca %struct.Mapper_struct*, align 8
  %6 = alloca i8*, align 8
  store i32 %0, i32* %4, align 4
  store %struct.Mapper_struct* %1, %struct.Mapper_struct** %5, align 8
  store i8* %2, i8** %6, align 8
  %7 = load i32, i32* %4, align 4
  %8 = load %struct.Mapper_struct*, %struct.Mapper_struct** %5, align 8
  %9 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %8, i32 0, i32 6
  store i32 %7, i32* %9, align 4
  %10 = load %struct.Mapper_struct*, %struct.Mapper_struct** %5, align 8
  %11 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %10, i32 0, i32 5
  store i32 1, i32* %11, align 8
  ret void
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @Mapper_doMap(%struct.Mapper_struct*, i8*) #0 {
  %3 = alloca %struct.Mapper_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Mapper_struct* %0, %struct.Mapper_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Mapper_struct*, %struct.Mapper_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %5, i32 0, i32 7
  %7 = load i32, i32* %6, align 8
  %8 = srem i32 %7, 2
  %9 = icmp eq i32 %8, 0
  br i1 %9, label %10, label %22

; <label>:10:                                     ; preds = %2
  %11 = load %struct.Mapper_struct*, %struct.Mapper_struct** %3, align 8
  %12 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %11, i32 0, i32 6
  %13 = load i32, i32* %12, align 4
  %14 = load %struct.Mapper_struct*, %struct.Mapper_struct** %3, align 8
  %15 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %14, i32 0, i32 6
  %16 = load i32, i32* %15, align 4
  %17 = mul nsw i32 %13, %16
  %18 = load %struct.Mapper_struct*, %struct.Mapper_struct** %3, align 8
  %19 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %18, i32 0, i32 4
  %20 = load %struct.Reducer_struct*, %struct.Reducer_struct** %19, align 8
  %21 = load i8*, i8** %4, align 8
  call void @Reducer_reduce1(i32 %17, %struct.Reducer_struct* %20, i8* %21)
  br label %34

; <label>:22:                                     ; preds = %2
  %23 = load %struct.Mapper_struct*, %struct.Mapper_struct** %3, align 8
  %24 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %23, i32 0, i32 6
  %25 = load i32, i32* %24, align 4
  %26 = load %struct.Mapper_struct*, %struct.Mapper_struct** %3, align 8
  %27 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %26, i32 0, i32 6
  %28 = load i32, i32* %27, align 4
  %29 = mul nsw i32 %25, %28
  %30 = load %struct.Mapper_struct*, %struct.Mapper_struct** %3, align 8
  %31 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %30, i32 0, i32 4
  %32 = load %struct.Reducer_struct*, %struct.Reducer_struct** %31, align 8
  %33 = load i8*, i8** %4, align 8
  call void @Reducer_reduce2(i32 %29, %struct.Reducer_struct* %32, i8* %33)
  br label %34

; <label>:34:                                     ; preds = %22, %10
  %35 = load %struct.Mapper_struct*, %struct.Mapper_struct** %3, align 8
  %36 = getelementptr inbounds %struct.Mapper_struct, %struct.Mapper_struct* %35, i32 0, i32 5
  store i32 0, i32* %36, align 8
  ret void
}

declare void @Reducer_reduce1(i32, %struct.Reducer_struct*, i8*) #1

declare void @Reducer_reduce2(i32, %struct.Reducer_struct*, i8*) #1

attributes #0 = { noinline nounwind optnone ssp uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+fxsr,+mmx,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0, !1}
!llvm.ident = !{!2}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 7, !"PIC Level", i32 2}
!2 = !{!"clang version 5.0.0 (tags/RELEASE_500/final)"}
